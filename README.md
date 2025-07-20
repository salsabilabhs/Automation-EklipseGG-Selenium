## ✏️ Test Scope Explanation

This automation project focuses on covering **happy flow scenarios** — the most common and ideal user interactions — based on prioritized features. The decision to focus on these scenarios was made to ensure the most critical functionalities work as expected, considering the limited timeframe for completion.

---

## ✅ Implemented Test Cases

The following areas have been covered in the implemented test cases:

- UI validation of key sections and navigational components
- Form submission using valid inputs across all steps
- Core user actions such as login, profile update, and password change
- Validation of labels, buttons, and visible fields
- Read-only field checks (e.g., email field is non-editable)

---

## ❌ Unimplemented Test Cases

Due to time constraints and prioritization, the following types of test cases were **not implemented** in this version:

- **Negative scenarios**, such as empty input, invalid format, or incomplete form submission
- **Error handling**, including validation messages for incorrect or missing data
- **Role-based UI/UX differences**, such as restrictions for Free vs Premium members
- **Edge cases and boundary value testing**, such as maximum character limits
- **Secondary flows or optional features** not considered high priority in this phase
- **Complex or AI-integrated functionalities**, which require deeper understanding before proper automation

---

## ⚙️ Technical Note

The scripting work in this project is mainly focused on features and flows I’m already **familiar and confident with**. For areas involving more advanced or dynamic functionality — especially those related to **AI-generated content or behavior** — I acknowledge that I still need to **study and explore further** before building stable and meaningful automation for them.

---

## 📌 Reason for Scope Limitation

1. **Feature Priority**  
   The main goal was to ensure the primary user flow functions correctly before expanding into more complex or less frequently used scenarios.

2. **Time Constraints**  
   As the implementation was done within a limited time window, test coverage was aligned with the highest priority paths to maximize value and stability.

3. **Learning Curve**  
   Some parts of the application (especially AI-related components) require more in-depth exploration and understanding, which are currently part of my ongoing learning process.

4. **Scalable Structure**  
   The automation framework was designed with modularity in mind, making it easy to extend and maintain in future test development.

---

## 📈 Future Enhancements

- **Simplified Test Suite Execution**  
  Test execution will be restructured to run from a cleaner and more modular `suites.xml`, making it easier to trigger full regression runs or targeted suites as needed.

- **Negative Flow Coverage**  
  Additional scripting will be added to cover negative test cases, including invalid inputs, error handling, and edge conditions — to strengthen overall coverage and improve system resilience.

- **AI-Related Functional Testing**  
  Automation for features involving AI (e.g., dynamic behavior, generated content, personalization) will be further explored and gradually enhanced as deeper understanding and reliable assertion strategies are developed.

---

## ▶️ How to Run the Tests

There are two main ways to run the test cases in this project:

### 1. Run Individual Test Files Manually

You can execute specific test files directly from your IDE (e.g., IntelliJ, Eclipse):

- Navigate to the test folder:  
  `automation-eklipsegg-selenium\src\test\java\selenium\tests`
- Open any test class you want to run (e.g., `login.java`, `home.java`, etc.)
- Click the **Run (▶️ Play)** button next to the method or class name to execute it

> This is useful for debugging or running selected tests during development.

### 2. Run Entire Test Suite via TestNG XML

Once the `suites.xml` file is simplified and structured properly, you can run a group of tests (e.g., smoke or regression) by right-clicking the XML file and choosing **Run**.

This is more suitable for full regression testing or CI integration.
