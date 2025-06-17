package dev.ikm.maven;

import java.util.UUID;

public abstract class AbstractTransformer implements Transformer {
    protected final UUID namespace;
    protected final GudidUtility gudidUtility;

    AbstractTransformer(UUID namespace) {
        this.namespace = namespace;
        this.gudidUtility = new GudidUtility(namespace);
    }

    @Override
    public UUID getNamespace() {
        return namespace;
    }

}
