public abstract class AbstractLogin {
    protected abstract boolean authenticate(String username, String password);
    protected abstract void handleLogin();

    public void startLogin() {
        handleLogin();
    }
}
