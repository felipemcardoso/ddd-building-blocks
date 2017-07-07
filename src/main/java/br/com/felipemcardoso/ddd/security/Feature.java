package br.com.felipemcardoso.ddd.security;

public class Feature {

    private String name;

    public Feature(String name) {
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
    	
    	if (!(obj instanceof Feature)) {
    		return false;
    	}

        Feature other = (Feature) obj;

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
