package dev.ikm.maven;

import dev.ikm.tinkar.composer.Composer;

import java.io.File;
import java.util.UUID;

public class GudidIdentifierTransformer extends AbstractTransformer {

    public GudidIdentifierTransformer(UUID namespace) {
        super(namespace);
    }

    @Override
    public void transform(File file, Composer composer) {
        // TODO
    }

}
