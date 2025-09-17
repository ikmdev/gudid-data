# gudid-data

### Team Ownership - Product Owner
Data Team

## Getting Started

Follow these instructions to generate a gudid data ORIGIN dataset:

1. Clone the [gudid-data repository](https://github.com/ikmdev/gudid-data)

```bash
git clone [Rep URL]
```

2. Change local directory to `gudid-data\gudid-origin`

3. Ensure the gudid-data/pom.xml contains the proper tags containing source filename for the files such as:
   <source.zip>, <source.version>, etc.

4. Enter the following command to build the ORIGIN dataset:

```bash
mvn clean install -U "-DMaven.build.cache.enable=false"
```

5. Enter the following command to deploy the ORIGIN dataset to Nexus:

```bash
mvn deploy -f gudid-origin -DdeployToNexus=true -Dmaven.deploy.skip=true -Dmaven.build.cache.enabled=false -Ptinkarbuild -DrepositoryId=nexus-snapshot
```

6. On Nexus, you will find the artifact at the following maven coordinates:

```bash
<dependency>
  <groupId>dev.ikm.data.gudid</groupId>
  <artifactId>gudid-origin</artifactId>
  <version>AccessGUDID_Delimited_Full_Release_20250804+1.0.0-SNAPSHOT</version>
</dependency>
```