# SCTP-SE-Module04-JAVA-DevOps - Project Team 2
## Module 04: Project Team 2 - HarbourBookingSystem


Set up the two main branches, **develop** and **release**, using the Git Flow model using the command-line interface (CLI), follow these steps:

### Step 1: Install Git Flow
> Ensure you have Git Flow installed on your system.
> If you haven't installed it yet, you can do so by following the instructions for your specific operating system.


### Step 2: Initialize Git Flow
In your project's repository directory, initialize Git Flow by running the following command:

```git flow init```

This command will prompt you to set up the branch names for **develop, main, feature, release, hotfix,** and **support** branches. Accept the default branch names by pressing Enter for all except **develop** and **release**.


### Step 3: To create the develop branch, use the following command:

```git flow feature start develop```

This command will create the developed branch from the current branch (usually main).


### Step 4: Create the Release Branch
To create the release branch, use the following command:

```git flow release start [release-version]```

Replace [release-version] with the version number of your release, e.g., 1.0.0. This command will create the release branch from the current branch (usually develop).

After creating the develop and release branches, you can use standard Git commands to work with and manage these branches during your development and release processes.
