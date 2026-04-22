# Task Manager

A robust, command-line interface (CLI) application built in Java for managing daily tasks, tracking priorities, and monitoring productivity through detailed statistics.

---

## 🚀 Features Overview

* **Task Lifecycle Management:** Create, update, and delete tasks with ease.
* **Detailed Metadata:** Support for descriptions, due dates, and priority levels.
* **Flexible Categorization:** Multi-tagging support for better organization.
* **Advanced Filtering:** List tasks by status, priority, or overdue state.
* **Productivity Insights:** Generate statistics to track your progress.

---

## 🛠 Installation & Build

### Prerequisites
* **Java Development Kit (JDK):** Version 11 or higher recommended.
* **Gradle:** (Included via the Gradle Wrapper).

### Building the Project
Clone the repository and run the build command from the root directory:
```bash
./gradlew build
```

---

## 💻 Usage & Examples

The application is executed via Gradle by passing commands through the `--args` flag.

### Basic Command Syntax
```bash
./gradlew run --args="<command> [arguments]"
```

### Common Examples
* **Create a Task:**
    ```bash
    ./gradlew run --args="create 'Fix Code' 'I need to get this running' 1 2025-06-01 bugs"
    ```
* **List Tasks:**
    ```bash
    ./gradlew run --args="list"
    ```
* **Show Statistics:**
    ```bash
    ./gradlew run --args="stats"
    ```

### Available Commands
| Command | Syntax | Description |
| :--- | :--- | :--- |
| `create` | `create <title> [desc] [priority] [due] [tags]` | Create a new task |
| `list` | `list [-s status] [-p priority] [-o]` | Filter and list tasks |
| `status` | `status <task_id> <new_status>` | Update completion status |
| `priority` | `priority <task_id> <new_priority>` | Update task urgency |
| `due` | `due <task_id> <new_due_date>` | Change the deadline |
| `tag` | `tag <task_id> <tag>` | Add a specific tag |
| `untag` | `untag <task_id> <tag>` | Remove a specific tag |
| `show` | `show <task_id>` | View full task details |
| `delete` | `delete <task_id>` | Permanently remove a task |
| `stats` | `stats` | View productivity summary |

---

## 📂 Project Structure

```text
java
├── app
│   └── TaskManager.java       # Core application logic
├── cli
│   └── TaskManagerCli.java    # Command-line entry point & parsing
├── model
│   ├── Task.java              # Task data object
│   ├── TaskPriority.java      # Priority Enums
│   └── TaskStatus.java        # Status Enums
└── storage
    └── TaskStorage.java       # Data persistence logic
```

---

## 🧪 Testing
To ensure system stability, run the automated test suite:
```bash
./gradlew test
```

---

## ⚙️ Configuration Options
* **Priority Levels:** Typically 1 (Highest) to 3 (Lowest).
* **Date Format:** Ensure dates are entered in `YYYY-MM-DD` format.
* **Tags:** Multiple tags should be entered as a comma-separated list (e.g., `"work,urgent"`).

---

## ❓ Troubleshooting
* **Permission Denied:** If `./gradlew` fails, run `chmod +x gradlew` to make the wrapper executable.
* **Unknown Command:** Ensure the command is wrapped in quotes inside the `--args` flag.
* **Parsing Errors:** If your title or description contains spaces, ensure it is enclosed in single quotes within the double-quoted args string.

---

## 🤝 Contributing
1.  Fork the repository.
2.  Create a feature branch (`git checkout -b feature/NewFeature`).
3.  Commit your changes (`git commit -m 'Add NewFeature'`).
4.  Push to the branch (`git push origin feature/NewFeature`).
5.  Open a Pull Request.

---

## 📄 License
This project is licensed under the MIT License - see the LICENSE file for details.


---

# User Guide: Create Task
**User Level:** Intermediate/Advanced

### 1. Prerequisites & Access
Before beginning this process, ensure you have the following:
* **Environment:** The application must be built and the environment variables configured.
* **Permissions:** Access to the `TaskStorage` directory or write-permissions for the database.
* **Tools:** A terminal/command prompt with Java and the Gradle wrapper installed.

---

### 2. Step-by-Step Instructions

1.  **Open your Terminal:** Navigate to the root directory of the `task-manager` project.
2.  **Verify Build Status:** Ensure the project is compiled to avoid runtime errors.
    ```bash
    ./gradlew build
    ```
3.  **Execute the Command:** Use the `run` task followed by the specific arguments for your action.
    * *Action:* Create a task.
    * *Syntax:* `create <title> [description] [priority] [due_date] [tags]`
    
    **Example Command:**
    ```bash
    ./gradlew run --args="create 'Finish Report' 'Q4 Financials' 1 2026-05-01 work,finance"
    ```
4.  **Confirm Output:** The system should return a unique Task ID. 
    > **Note:** If you do not see a "Created task with ID: ..." message, the process did not complete.

---

### 3. [Placeholder for Screenshot/Visuals]
*[Insert Image of Terminal showing successful task creation]*

---

### 4. Potential Issues & Common Mistakes
* **Quoting Arguments:** One of the most common errors is failing to wrap the entire argument string in double quotes while using single quotes for titles with spaces. 
    * ❌ Incorrect: `--args=create New Task`
    * ✅ Correct: `--args="create 'New Task'"`
* **Date Formatting:** The system expects `YYYY-MM-DD`. Using `MM-DD-YYYY` will cause a parsing error or store incorrect data.
* **Priority Range:** Providing a priority outside of the 1–3 range may cause sorting issues in the `list` view.

---

### 5. Troubleshooting

| Problem | Likely Cause | Solution |
| :--- | :--- | :--- |
| **"Command not found"** | Gradle wrapper not executable. | Run `chmod +x gradlew` (Linux/Mac). |
| **NumberFormatException** | Priority was entered as text. | Ensure the 3rd argument is a digit (e.g., `1`). |
| **Empty List after Create** | Storage write-failure. | Check if the `storage/` directory is read-only. |
| **"Unknown command"** | Typo in the action keyword. | Verify you typed `create` and not `cretae`. |

---


To provide the most effective FAQ, I’ve structured this based on your **Task Manager** project. Since your target audience likely ranges from developers to CLI-power users, the tone is technical yet accessible.

---

# Task Manager: Frequently Asked Questions (FAQ)

### 📊 Project Overview
The **Task Manager** is a lightweight, Java-based CLI tool designed for users who prefer managing their workflows directly from the terminal. It supports task prioritization, status tracking, and automated productivity statistics.

---

### 1. Getting Started
**Q: How do I install the Task Manager?**
**A:** There is no "installer" in the traditional sense. Since it is a Java/Gradle project, you simply need to clone the repository and ensure you have JDK 11+ installed. You can verify everything is ready by running `./gradlew build`.

**Q: Do I need to install Gradle manually?**
**A:** No. The project includes the Gradle Wrapper (`gradlew`). Using `./gradlew` will automatically download the correct version of Gradle for the project.

**Q: How do I run my first command?**
**A:** All commands are passed through the Gradle `run` task using the `--args` flag. For example: `./gradlew run --args="stats"`.

---

### 2. Common Features & Functionality
**Q: How does the priority system work?**
**A:** By default, the system uses a numeric scale. We recommend using **1 for High**, **2 for Medium**, and **3 for Low**. If you don't specify a priority during creation, it defaults to **2**.

**Q: Can I add multiple tags to a single task?**
**A:** Yes. When using the `create` command, the final argument is a comma-separated string.
*Example:* `... "tag1,tag2,tag3"`. The system automatically trims spaces, so `"tag1, tag2"` works perfectly.

**Q: What does the `stats` command actually show?**
**A:** The `stats` command provides a high-level summary of your productivity, including the total number of tasks, a breakdown of tasks by status (Pending vs. Completed), and how many tasks are currently overdue.

---

### 3. Troubleshooting Common Issues
**Q: Why do I get a "Task Not Found" error even though I see it in the list?**
**A:** Ensure you are using the correct **Task ID**. Task IDs are case-sensitive and must match the string returned when the task was originally created.

**Q: I’m getting a `NumberFormatException`. What happened?**
**A:** This usually happens during the `create` command if the **Priority** argument is not a whole number. Ensure the third argument after the title and description is a digit (e.g., `1`, `2`, or `3`).

**Q: My command arguments with spaces are failing. How do I fix this?**
**A:** This is a common CLI hurdle. You must wrap the entire argument string in double quotes, and then wrap titles or descriptions containing spaces in single quotes.
*Correct Syntax:* `./gradlew run --args="create 'My Task Title' 'The Description'"`

---

### 4. Data & Persistence (Specific Area)
**Q: Where is my task data stored?**
**A:** Task data is handled by the `TaskStorage` class. By default, it saves tasks to a local file within the project directory (usually a `.json` or `.txt` file depending on your specific implementation of the storage layer).

**Q: Can I manually edit the storage file?**
**A:** It is **not recommended**. Manually editing the underlying data file can lead to corruption or parsing errors. Always use the CLI commands (`status`, `priority`, `due`) to modify tasks.

**Q: Will my tasks be deleted if I run `./gradlew clean`?**
**A:** No. The `clean` command only removes the `build/` folder and compiled `.class` files. Your stored data persists independently of the build artifacts.

---