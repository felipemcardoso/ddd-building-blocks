package br.com.felipemcardoso.ddd.security;

public class Role {

    public static final Role ALL = new Role("ALL");
    
	private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
    	if (!(obj instanceof Role)) {
    		return false;
    	}
    	
        Role other = (Role) obj;

        return this.name.equals(other.getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public String toString() {
    	return getName();
    }
}
