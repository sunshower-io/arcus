package io.sunshower.arcus.config;

import static io.sunshower.arcus.config.ConfigurationLoader.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.sunshower.arcus.logging.Logging;
import java.io.StringReader;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.val;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

public class ConfigurationLoaderTest {
    @XmlRootElement(name = "snake-case")
    static class Cfg {
        @XmlAttribute(name = "value")
        private String value;
    }

    static {
      Logging.setLevel("io.sunshower.arcus.config", Level.ALL);
    }

    @Test
    void ensureConfigurationLoaderCanLoadConfigurationFromYaml() throws Exception {

        val cfg =
                """
                        value: "hello!"
                        """
                        .stripIndent();

        val result = load(Cfg.class, new StringReader(cfg), "application/x-yaml");
        assertEquals(result.value, "hello!");
    }
}
