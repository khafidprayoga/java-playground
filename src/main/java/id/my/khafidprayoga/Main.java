package id.my.khafidprayoga;

import java.util.function.Predicate;

interface Payable {
    public boolean send(int address, long values) throws PaymentError;

    default void thisIsBackwardMethod() {
    }

    ;
}

interface ERC20L2Rollup extends Payable {
    static long batchProcessorAddr = 12332133;

    default void bundleTx() {
        System.out.println("ERC20L2Rollup bundling the transasction");
    }

    default void verifyHash() {
        System.out.println("ERC20L2Rollup verifying the hash");
    }
}

interface USDC extends Payable {
    public void mint(int address, long values) throws PaymentError;

    public void burn(int address, long values) throws PaymentError;

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

class OptimismWallet extends EthereumWallet implements USDC, ERC20L2Rollup {

    @Override
    public void mint(int address, long values) throws PaymentError {
        System.out.printf("mint amount %d USDC on the adddress %s%n", values, address);
    }

    @Override
    public void burn(int address, long values) throws PaymentError {
        System.out.printf("burning amount %d on the adddress %s to blackhole%n", values, address);
    }

    @Override
    public boolean send(int address, long values) throws PaymentError {
        var msg = String.format("Transferring amount of %d USDC to address %s sucessfully", values, address);
        System.out.println(msg);
        this.bundleTx();
        System.out.printf("tx bundled to %s%n", ERC20L2Rollup.batchProcessorAddr);
        return true;
    }
}

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

// Marker class for clarity and readble code
interface Revokable{}
interface Expirable{}

abstract class AccessToken{
    abstract  void issue();
    abstract  void refresh();
}

class AccessTokenJWT extends AccessToken implements  Revokable, Expirable {

    @Override
    void issue() {

    }

    @Override
    void refresh() {

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

        Greeting g = (String name) -> {
            System.out.println("Hello, " + name);
        };
        g.sayHello("John");

        Predicate<String> isNotEmpty = (name) -> !name.isEmpty();
        System.out.println(isNotEmpty.test("John"));
    }
}