package id.my.khafidprayoga;

interface Payable {
    public boolean send(int address, long values) throws PaymentError;
}

interface USDC extends Payable {
    public void mint(int address, long values) throws PaymentError;

    public void burn(int address, long values) throws PaymentError;

    public void bridge(int address, int toL2Address, long values) throws PaymentError;
}

class SolanaWallet implements Payable {
    @Override
    public boolean send(int address, long values) throws PaymentError {
        System.out.println("Init solana wallet transfer...");
        if (values < 100) {
            throw new PaymentError(PaymentErrorCode.GAS_FEES_REQUIRED, "must be transfer 100 tokens or more, to cover gas fees");
        }

        var msg = String.format("Transferring amount of %d to address %s sucessfully", values, address);
        System.out.println(msg);

        return true;
    }
}

class EthereumWallet implements Payable {

    @Override
    public boolean send(int address, long values) throws PaymentError {
        System.out.println("Init ethereum wallet transfer...");
        // wait 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new PaymentError(PaymentErrorCode.SETTLEMENT_ERROR, e.getMessage());
        }

        var msg = String.format("Transferring amount of %d to address %s sucessfully", values, address);
        System.out.println(msg);
        return true;
    }
}

class OptimismWallet extends EthereumWallet implements USDC {

    @Override
    public void mint(int address, long values) throws PaymentError {
        System.out.printf("mint amount %d USDC on the adddress %s%n", values, address);
    }

    @Override
    public void burn(int address, long values) throws PaymentError {
        System.out.printf("burning amount %d on the adddress %s to blackhole%n", values, address);
    }

    @Override
    public void bridge(int address, int toL2Address, long values) throws PaymentError {
        System.out.println("Init bridge provider Stargate.... ");
        System.out.println("Selecting best route");
    }

    @Override
    public boolean send(int address, long values) throws PaymentError {
        var msg = String.format("Transferring amount of %d USDC to address %s sucessfully", values, address);
        System.out.println(msg);
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        int usernameAccount = 100011231;
        Payable payer = new EthereumWallet();

        // change dependency
        payer = new SolanaWallet();

        // init usdc of extended payable contract
        OptimismWallet optimism = new OptimismWallet();

        // change to v2 using usdc on optimism L2 solution
        payer = optimism;
        payer.send(usernameAccount, 20);

        // mint add token to the address
        USDC op = optimism;
        op.mint(1001, 200);
    }
}