# CICD Demo using Github Actions and Armory CDaaS on K8s Cluster (Blue/Green Deployment) - Spring Boot Java App

There are two ways to trigger a deployment with Armory CDaaS:

1.  Via CLI
2.  Via Github Actions

## Via CLI

To deploy using the CLI, you need to have the Armory Version Manager (AVM) and CLI installed. There are two options for installation: local installation or automated installation.

### Local Installation

You can install the AVM and CLI manually by downloading the AVM binary and the CLI binary. The AVM enables you to easily download, install, and update the CLI.

### Automated Installation

You can install the CLI and AVM using the following one-line command on a machine that has access to your Kubernetes cluster:

Copy code

`curl -sL go.armory.io/get-cli | bash`

After installation completes, start a new terminal session or source your profile to add the AVM and CLI to your PATH.

### Log In

Log in to Armory’s hosted deployment services using the following command:

Copy code

`armory login`

### Create a template:

Use this to create a canary deployment strategy template:

Copy code

`armory template kubernetes canary > canary.yaml`

But for us, we will going to use the tutorial in this repo to perform blue green deployments: [https://github.com/armory/docs-cdaas-sample/blob/main/deploy.yml](https://github.com/armory/docs-cdaas-sample/blob/main/deploy.yml)

### Start the Deployment

Start the deployment using the following command:

Copy code

`armory deploy start -f canary.yaml --watch`

## Via Github Actions

Configure the action by creating a file in the `.github/workflows` directory with the following content format:

Copy code

```
name: <descriptive-name> # This name appears in the Actions screen in the GitHub UI.

on:
  push: # What triggers a deployment. For example, `push`.
    branches:
      - <branchName> # What branch triggers a deployment. For example, `main`.

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v2

      - name: Armory CD-as-a-Service Deployment
        id: deploy
        uses: armory/cli-deploy-action@main
        with:
          clientId: "${{ secrets.CDAAS_CLIENT_ID }}"
          clientSecret: "${{ secrets.CDAAS_CLIENT_SECRET }}"
          path-to-file: "<path-to-deployment-file>"
          waitForDeployment: <true-or-false>``
```

### Screenshots

![Armory Console](/images/1.PNG)
![Deployed App](/images/2.PNG)
