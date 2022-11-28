package by.st.model;

public enum Permission {
    QUERIES_READ("queries:read"),
    QUERIES_WRITE("queries:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}