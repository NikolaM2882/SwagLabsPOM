# SwagLabsPOM

**Automated Page Object Model (POM) test suite for [SauceDemo](https://www.saucedemo.com)** using **Java**, **Selenium**, **Maven**, and **TestNG**.

---

## 🚀 Features

- **Page Object Model** architecture for maintainable readability and reusability  
- ✅ Automated test cases: login, logout, product listing, add to cart, checkout, sort function  
- 🧪 Parallel test execution across browsers (Chrome, Firefox)  
- ⚙️ Configurable via `config.properties`  
- 📋 TestNG reporting out-of-the-box

---

## 📁 Project Structure

```
SwagLabsPOM/
├─ src/
│  ├─ main/java/com/yourorg/pages      # Page Object classes
│  ├─ test/java/com/yourorg/tests      # TestNG test classes
│  └─ resources/config.properties      # Test configuration
├─ pom.xml                             # Maven config + dependencies
└─ testng.xml                          # TestNG suite setup
```

---

## 🛠️ Technologies Used

- **Java 17+**
- **Selenium WebDriver** (v4.x)
- **TestNG** for test framework
- **Maven** for build management
- **ChromeDriver**, **FirefoxDriver** for browser automation

---

## ⚙️ Setup & Installation

1. **Clone the repo**
    ```bash
    git clone https://github.com/NikolaM2882/SwagLabsPOM.git
    cd SwagLabsPOM
    ```

2. **Configure test drivers**
   - Download ChromeDriver/FirefoxDriver matching your browser versions
   - Place executables in `drivers/` or include in system `PATH`

3. **Adjust properties**
   - Open `src/main/resources/config.properties`
   - Set values for:
     ```properties
     base.url=https://www.saucedemo.com
     browser=chrome
     explicit.wait=10
     ```

4. **Install dependencies & run tests**
    ```bash
    mvn clean test
    ```

5. **Run via TestNG suite**
    - Execute tests using your IDE or:
      ```bash
      mvn test -DsuiteXmlFile=testng.xml
      ```

---

## 🧪 Tests Included

- **Login & logout** validation  
- **Product listing** checks and item detail navigation, product sort
- **Check out** testing whole process from add to cart to purchase confirmation 

- Parallel execution of critical flows across multiple browsers

---

## 📈 Reporting

After execution, find the default TestNG report in:
```
target/surefire-reports/index.html
```
Customize reports via `testng.xml` for grouping, HTML reporters, data-driven runs, etc.

---

## 📌 Extending the Framework

To extend the POM architecture, you can:

- Add new `Page` classes under `com.yourorg.pages/`
- Write tests under `com.yourorg.tests/`
- Use `config.properties` or a `data.properties` for environment-specific URL, credentials
- Integrate **ExtentReports** or **Allure** for advanced reporting
- Add **DataProviders** for parameterized tests

---

## 🤝 Contributing

Contributions are welcome! Please:

1. Fork the repo  
2. Create a feature branch (`git checkout -b feature/my-feature`)  
3. Commit your changes  
4. Submit a pull request

---

## 📝 License

This project is released under the **MIT License**. See [LICENSE](LICENSE) for details.

---

## 📞 Author

Developed by **Nikola M.**

If you'd like help setting up a specific test, or integrating CI/CD or other reports, feel free to open an issue or contact me directly!

---

*Happy testing!* 🎉
