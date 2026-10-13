# Account Service — Enterprise Git Practice

An existing Java 21 / Spring Boot 3 Maven REST API used to practice GitHub team workflows. Data is in memory; no database or credentials required.

## Run

Open the folder in IntelliJ as a Maven project and run `AccountServiceApplication`, or run `mvn spring-boot:run` from the repository root.

## Test

`mvn test`

## Existing endpoints

- `GET http://localhost:8080/api/accounts/1001` — existing account
- `GET http://localhost:8080/api/accounts/9999` — HTTP 404

## Practice tickets (do NOT implement these on main)

- ACC-101: Add `GET /api/accounts/{accountId}/balance` that returns only account ID, balance and currency. Add tests.
- ACC-102: Add a new in-memory account and its unit test.
- ACC-103: Add an endpoint for listing all accounts with tests.

## Git workflow

First upload these starter files to the root of a GitHub repository on `main` (the baseline). Then **clone the GitHub repository into a separate folder** as a developer. For each ticket, `git switch main`, `git pull --ff-only origin main`, `git switch -c feature/ACC-101-account-balance`, edit and test, `git add`, `git commit`, `git push -u origin ...`, open PR, merge, and update local main.

Do not upload the ZIP itself as the application; extract its contents to the repository root. Never commit credentials or local build artifacts.
