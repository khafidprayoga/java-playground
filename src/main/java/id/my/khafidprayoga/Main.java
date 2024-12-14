package id.my.khafidprayoga;

interface Payable {
    public boolean send(int address, long values) throws PaymentError;
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

public class Main {
    public static void main(String[] args) {
        int usernameAccount = 100011231;
        Payable payer = new EthereumWallet();
        // change dependency
        payer = new SolanaWallet();

        payer.send(usernameAccount, 20);
    }
}