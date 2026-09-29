# AatendenceAPP — Market Analysis

> **Evidence base.** This document was researched on 2026-09-29 from vendor pricing pages,
> published analyst figures and the owner's market-review work (2026-09-26). No number
> here is invented. Where a figure could not be independently verified it is marked
> **[TO BE VALIDATED]**; verify it before the document is used in an investor or
> grant setting. Sources are listed in §8.

## 1. Product in one sentence

> Attendio — an offline-first Android college-attendance app (Java) with session management, per-student analytics and CSV export.

## 2. Problem statement

- **Who feels the problem:** Colleges, training centers and small institutions running attendance on paper/Excel.
- **What they do today instead:** manual processes, spreadsheets, rented SaaS — see §4.
- **Cost of the status quo:** measurable in lost revenue / manual labor overhead
  **[TO BE VALIDATED for this specific segment]**.

## 3. Market definition

| Field | Value |
| --- | --- |
| Category | Attendance management & lightweight HR analytics |
| Geographic scope | Pakistan-first, generalizable |
| Target segment / persona | Colleges, training centers and small institutions running attendance on paper/Excel |
| Estimated total addressable market | Attendance/HR suites are a mature enterprise category; the local institution segment is served by general tools **[TO BE VALIDATED — cite a specific figure]** |
| Serviceable addressable market | Depends on distribution reach; **[TO BE VALIDATED]** |
| Beachhead segment | Colleges, training centers and small institutions running attendance on paper/Excel |

## 4. Demand signals

> Persistent institutional need; compliance and reporting drive replacement of spreadsheet workflows

| Signal | Evidence | Status |
| --- | --- | --- |
| Category demand | Mature/validated category with well-funded entrants | Confirmed |
| Competitive floor | Incumbent pricing and free tiers are public and low | Confirmed (see §5) |
| Own sales/usage data | Not instrumented in this repo | **[TO BE MEASURED]** |

## 5. Competitive landscape

| Competitor | Entry price (2026) | Positioning | Weakness we can exploit |
| --- | --- | --- | --- |
| **Leapsome** | Quote / mid-market | HR + performance suites | Enterprise pricing |
| **Gecko HRM** | ~$2–4/employee/mo | Full HRIS for growing teams | Module-heavy for a syllabus |
| **KollabHR** | Bundled ergonomics suites | Full HR + attendance | Enterprise sales motion |
| **Winslow** | Enterprise | Attendance + scheduling | Out of reach for small institutions |
| **Spreadsheets** | Free | Universal | Manual, error-prone, no analytics |

## 6. Differentiation

Grounded in what this build actually does (see `06-architecture.md`):

- **Distinctive capability in code:** Offline-first Android attendance with at-risk analytics, per-student tracking and CSV export, delivered as a signed APK for a specific institution or classroom; enterprise vendors target HR teams, not classrooms.
- **Capability a competitor would need to replicate:** proxy of the build's core path.
- **Why defensible:** depth of vertical fit and delivery ownership, not a generic dashboard.

## 7. Risks

| Risk | Likelihood | Impact | Mitigation |
| --- | --- | --- | --- |
| Category commoditized / incumbent floor falling | Medium–High | Medium | Position on differentiation above, not price |
| Unverified market figures | High | High | Keep `[TO BE VALIDATED]` markers until sourced |
| Claims ahead of code (demo vs. shipped) | Medium | High | Keep README/copy aligned with the source tree |

## 8. Sources

Accessed 2026-09-29; vendor pricing changes — re-verify before any pricing decision.

- https://www.leapsome.com/pricing
- https://www.gecko.hr/en/
- https://kollabr.com/
