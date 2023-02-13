# CICD Demo using Github Actions and Armory CDaaS on K8s Cluster (Blue/Green Deployment)

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

Use this to create a canary deployment strategy template;

```bash
armory template kubernetes canary > canary.yaml
```

But for us, we will going to use the tutorial in this repo to perform blue green deployments: https://github.com/armory/docs-cdaas-sample/blob/main/deploy.yml

### Start the Deployment

Start the deployment using the following command:

Copy code

`armory deploy start -f canary.yaml --watch`

## Via Github Actions

Details on deploying via Github Actions will be added here.
