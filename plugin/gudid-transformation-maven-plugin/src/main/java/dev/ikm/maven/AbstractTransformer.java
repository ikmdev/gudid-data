package dev.ikm.maven;

import java.util.UUID;

public abstract class AbstractTransformer implements Transformer {
    protected final UUID namespace;
    protected final GudidUtility gudidUtility;

    AbstractTransformer(GudidUtility gudidUtility) {
        this.gudidUtility = gudidUtility;
        this.namespace = gudidUtility.getNamespace();
    }

    @Override
    public UUID getNamespace() {
        return namespace;
    }

}
