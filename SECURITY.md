# Security Policy

## Supported Versions

The project is actively maintained. Guides and fixes apply to the latest release on the `main` branch.

| Version                | Supported          |
| ---------------------- | ------------------ |
| main (unreleased)      | :white_check_mark: |
| < 1.0                  | :x:                |

## Reporting a Vulnerability

Please **do not** open a public issue for security problems. Instead, report them privately by opening a GitHub Security Advisory at:

https://github.com/mhklogs/AatendenceAPP/security/advisories/new

We aim to acknowledge reports within 48 hours and to ship a fix as soon as the impact is understood.

## Notes
- This app stores data locally in SQLite; passwords are kept on-device.
- No external services or network permissions are used by the app.