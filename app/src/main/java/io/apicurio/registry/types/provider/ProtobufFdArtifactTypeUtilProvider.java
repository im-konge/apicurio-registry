/*
 * Copyright 2020 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.registry.types.provider;

import io.apicurio.registry.content.canon.ContentCanonicalizer;
import io.apicurio.registry.content.canon.NoOpContentCanonicalizer;
import io.apicurio.registry.content.extract.ContentExtractor;
import io.apicurio.registry.content.extract.NoopContentExtractor;
import io.apicurio.registry.rules.compatibility.CompatibilityChecker;
import io.apicurio.registry.rules.compatibility.ProtobufFdCompatibilityChecker;
import io.apicurio.registry.rules.validity.ContentValidator;
import io.apicurio.registry.rules.validity.ProtobufFdContentValidator;
import io.apicurio.registry.types.ArtifactType;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Ales Justin
 */
@ApplicationScoped
public class ProtobufFdArtifactTypeUtilProvider extends AbstractArtifactTypeUtilProvider {
    @Override
    public ArtifactType getArtifactType() {
        return ArtifactType.PROTOBUF_FD;
    }

    @Override
    protected CompatibilityChecker createCompatibilityChecker() {
        return new ProtobufFdCompatibilityChecker();
    }

    @Override
    protected ContentCanonicalizer createContentCanonicalizer() {
        return new NoOpContentCanonicalizer();
    }

    @Override
    protected ContentValidator createContentValidator() {
        return new ProtobufFdContentValidator();
    }

    @Override
    protected ContentExtractor createContentExtractor() {
        return NoopContentExtractor.INSTANCE;
    }
}
