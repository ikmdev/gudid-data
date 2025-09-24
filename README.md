# GUDID Pipeline

**Prerequisites**

* JDK 24+
* Maven 3.9.9+
* Nexus Repository (optional)

**Clone Project and Configure Maven Settings**

1. Clone the [gudid-data repository](https://github.com/ikmdev/gudid-data)

   ```
   git clone https://github.com/ikmdev/gudid-data.git
   ```

2. Configure Maven settings.xml based on the [provided sample](https://ikmdev.atlassian.net/wiki/spaces/IKDT/pages/1036648449/Centralized+Documentation+for+Maven+Settings+File+Configuration).

3. Change local directory to `gudid-data`

**Run Origin Packaging**

The following source data is required for this pipeline and can be obtained from GUDID:

* AccessGUDID_Delimited_Full_Release_20250804.zip
* foiclass.zip

More information can be found on: https://accessgudid.nlm.nih.gov and https://www.fda.gov/medical-devices/classify-your-medical-device/download-product-code-classification-files

1. Place the downloaded ZIPs in your ~/Downloads directory.

2. Ensure the properties defined in gudid-data/pom.xml are set to the correct file names:
   - <source.zip>
   - <foi.source.zip>

3. Run origin packaging and deployment.

   To deploy origin artifact to a shared Nexus repository, run the following command, specifying the repository ID and URL in `-DaltDeploymentRepository`
   ```
   mvn --projects gudid-origin --also-make clean deploy -Ptinkarbuild -DaltDeploymentRepository=tinkar-snapshot::https://nexus.tinkar.org/repository/maven-snapshots/ -Dmaven.build.cache.enabled=false
   ```

   To install origin artifact to a local M2 repository, run the following command:
   ```
   mvn --projects gudid-origin --also-make clean install -Ptinkarbuild,generateDataLocal -Dmaven.build.cache.enabled=false
   ```

**Run Transformation Pipeline**

The transformation pipeline can be built after origin data is available in Nexus or a local M2 repository.

1. Build the pipeline with the following command:
   ```
   mvn clean install -U -Ptinkarbuild -Dmaven.build.cache.enabled=false
   ```

2. Deploy transformed data artifacts to Nexus, run the following command:
   ```
   mvn --projects gudid-export --also-make deploy -Ptinkarbuild -DaltDeploymentRepository=tinkar-snapshot::https://nexus.tinkar.org/repository/maven-snapshots/ -Dmaven.build.cache.enabled=false
   ```
   
