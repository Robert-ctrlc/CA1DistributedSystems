```markdown
# 🌐 CA1 — Distributed Systems (Course Assignment 1)

> A compact, workshop-style repository for implementing and experimenting with core distributed systems concepts: message passing, replication, consensus, failure simulation, and performance measurement. Designed for coursework, labs, and self-study. ✨

[![License](https://img.shields.io/badge/license-MIT-blue)](./LICENSE) [![Issues](https://img.shields.io/github/issues/Robert-ctrlc/CA1DistributedSystems)](https://github.com/Robert-ctrlc/CA1DistributedSystems/issues) ![Language](https://img.shields.io/github/languages/top/Robert-ctrlc/CA1DistributedSystems)

---

## Table of contents 📚

- [About](#about)
- [What's included](#whats-included)
- [Getting started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Install](#install)
  - [Run the system](#run-the-system)
  - [Run tests & simulations](#run-tests--simulations)
- [Project structure](#project-structure)
- [How to work through the exercises](#how-to-work-through-the-exercises)
- [Examples & common workflows](#examples--common-workflows)
- [Contributing](#contributing)
- [Style & conventions](#style--conventions)
- [License](#license)
- [Contact](#contact)

---

## About

This repository houses the coursework for CA1: Distributed Systems. It contains reference implementations, exercises, and simulations intended to help you learn practical distributed systems building blocks such as:

- Peer-to-peer and client-server communication
- Reliable messaging and retries
- Replication and state synchronization
- Leader election and basic consensus patterns
- Fault injection and failure handling
- Measurement and visualization of latency/throughput

Goals:
- Give hands-on experience with networked components.
- Emphasize testability, reproducibility, and small iterative refactors.
- Provide clear exercises that can be extended into final reports or demos.

---

## What's included 🔍

- /src — source code for nodes, clients, and utilities
- /configs — example configurations for multi-node runs
- /simulations — scripts to run multi-node topologies and failure scenarios
- /docker — Dockerfiles and docker-compose examples for containerized runs
- /docs — lecture notes, architecture diagrams, and assignment brief
- /tests — unit/integration tests and harnesses
- /benchmarks — scripts and sample results for performance experiments
- README.md — this file
- LICENSE — project license (MIT)

Each exercise or task should include:
- problem.md — description & acceptance criteria
- tests/ — deterministic tests to validate behavior
- example-configs/ — config files to reproduce scenarios

---

## Getting started ⚡

### Prerequisites
- Git
- Docker & Docker Compose (recommended for multi-node runs)
- Language runtime(s) used in /src (common options: Java 11+, Python 3.8+, Go 1.18+)
- Make (optional) for convenience scripts

Tip: Check /src/README.md or the root docs to see the primary language/tooling used for this assignment.

### Install
Clone the repo:
```bash
git clone https://github.com/Robert-ctrlc/CA1DistributedSystems.git
cd CA1DistributedSystems
```

If the project uses:
- Java (Maven):
  ```bash
  mvn clean package
  ```
- Java (Gradle):
  ```bash
  ./gradlew build
  ```
- Python:
  ```bash
  python -m venv .venv
  source .venv/bin/activate
  pip install -r requirements.txt
  ```
- Go:
  ```bash
  go build ./...
  ```

Or use Docker for a reproducible environment:
```bash
docker-compose up --build
```

### Run the system
Start a local multi-node topology (example using docker-compose):
```bash
docker-compose up --scale node=3
```

Run nodes locally (example placeholder):
```bash
# Example: run a node instance (adjust to project language)
python src/node.py --id 1 --config configs/cluster.json
```

Start a client to send workload:
```bash
python src/client.py --target 127.0.0.1:9001 --ops 1000
```

Adjust commands per the actual language & entrypoints in /src.

### Run tests & simulations
Run tests (example):
```bash
# Java (Maven)
mvn test

# Python (pytest)
pytest -q
```

Run a simulation harness:
```bash
# Example: launch a prepared simulation which injects failures and logs results
./simulations/run_churn_scenario.sh
```

---

## Project structure 🧭

- src/            — node implementations, client code, protocols
- configs/        — cluster and node configuration files
- docker/         — containerization and compose files
- simulations/    — scenario scripts (start/stop/failure injection)
- tests/          — unit and integration tests
- docs/           — assignment brief, diagrams, and writeups
- benchmarks/     — measurement tools and sample outputs

Naming notes:
- Node executables named node-<id> or started with --id flags
- Configs are JSON/YAML to make experiment reproducible
- Tests should be deterministic and runnable in CI

---

## How to work through the exercises ✅

1. Read the task in docs/ or the exercise problem.md.
2. Run the provided tests or simulation to observe baseline behavior.
3. Create a focused branch for your work:
   ```bash
   git checkout -b feat/ca1-exercise-<yourname>
   ```
4. Implement changes in small commits, keep tests green frequently.
5. Document design choices and trade-offs in a short notes file or PR description.
6. Open a pull request with:
   - Title: "CA1: <exercise> — short description"
   - Body: what changed, why, how to run the validation scenario

For students: include screenshots/plots of experiment results and short analysis in the PR.

---

## Examples & common workflows 🛠️

- Run a 3-node cluster locally (via Docker Compose):
  ```bash
  docker-compose -f docker/docker-compose.local.yml up --build
  ```

- Inject a network partition in a running simulation:
  ```bash
  ./simulations/partition.sh --nodes 1,2 --drop 1m
  ```

- Collect logs and reproduce:
  ```bash
  ./scripts/collect_logs.sh /tmp/experiment-1 && tar czf experiment-1.tar.gz /tmp/experiment-1
  ```

- Reproduce a benchmark and plot results:
  ```bash
  ./benchmarks/run_latency_benchmark.sh
  ./benchmarks/plot_results.py results/latency.json
  ```

Adjust paths & flags to match the project’s actual scripts.

---

## Contributing 🤝

Contributions are welcome from students, TAs, and instructors. Please:
- Open issues for bugs, missing exercises, or improvements.
- Keep PRs small and focused.
- Run tests & linters before submitting.
- Provide reproducible steps in the PR description.

If adding new experiments:
- Include configs for reproducibility
- Add a small README in the experiment folder explaining the scenario

Code of conduct: Be respectful and focus on constructive feedback.

---

## Style & conventions 🧾

- Keep functions and modules small and single-responsibility.
- Prefer clear, deterministic tests for distributed scenarios.
- Use logging (structured if possible) and avoid excessive stdout for programmatic runs.
- Keep configs separate from code: parametrise behavior via config files or flags.
- Follow the project's linter and formatting rules (see /docs/style.md if present).

---

## License ⚖️

This project is available under the MIT License. See [LICENSE](./LICENSE) for details.

---

## Contact 📬

Maintainer / Course owner: Robert-ctrlc  
Repo: https://github.com/Robert-ctrlc/CA1DistributedSystems

Good luck with the assignment — happy debugging, testing, and experimenting! 🚀🔧
```
