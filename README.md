# gudid-data

### Team Ownership - Product Owner
Data Team

## Getting Started

Follow these instructions to generate a gudid dataset:

1. Clone the [gudid-data repository](https://github.com/ikmdev/gudid-data)

```bash
git clone [Rep URL]
```

2. Change local directory to `gudid-data`

3. Download AccessGUDID File from ACCESS GUDID/FDA Product Code Classification Files: (https://accessgudid.nlm.nih.gov/download / https://www.fda.gov/medical-devices/classify-your-medical-device/download-product-code-classification-files)

4. Place the downloaded AccessGUDID_Delimited_Full_Release_*_.zip in your local Downloads directory.

5. Ensure the gudid-data/pom.xml contains the proper tags containing source filename for the downloaded files such as:
   <source.zip>, <source.version>, <foi.source.zip>, <starterSet>, <changeSet>, etc.

6. Create a ~/Solor directory and ensure ~/Solor/generated-data does not exist or is empty.

7. You can create a reasoned or unreasoned dataset by either including or commenting out the gudid-data/pom.xml <module>gudid-reasoner</module>

8. Enter the following command to build the dataset:

```bash
mvn clean install -U "-DMaven.build.cache.enable=false"
```

9. Enter the following command to deploy the dataset:

```bash
mvn deploy -f gudid-export "-DdeployToNexus=true" "-Dmaven.deploy.skip=true" "-Dmaven.build.cache.enabled=false"
```

