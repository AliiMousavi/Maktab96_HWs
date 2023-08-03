#!/bin/bash

undone_tasks_file="undone_tasks.txt"
completed_tasks_file="completed_tasks.txt"
deleted_tasks_file="deleted_tasks.txt"

initialize_files() {
    if [ ! -f "$undone_tasks_file" ]; then
        touch "$undone_tasks_file"
    fi

    if [ ! -f "$completed_tasks_file" ]; then
        touch "$completed_tasks_file"
    fi

    if [ ! -f "$deleted_tasks_file" ]; then
        touch "$deleted_tasks_file"
    fi
}

add_task() {
    echo -n "Enter task: "
    read task
    echo "$task" >> "$undone_tasks_file"
    echo "Task added: $task"
}

show_undone_tasks() {
    if [ ! -s "$undone_tasks_file" ]; then
        echo "No undone tasks."
    else
        echo "Undone tasks:"
        cat "$undone_tasks_file"
    fi
}

mark_task_done() {
    echo -n "Enter task to mark as done: "
    read task

    if grep -Fxq "$task" "$undone_tasks_file"; then
        grep -vFx "$task" "$undone_tasks_file" > temp.txt && mv temp.txt "$undone_tasks_file"
        echo "$task" >> "$completed_tasks_file"
        echo "Task marked as done: $task"
    else
        echo "Task not found in undone tasks."
    fi
}

show_completed_tasks() {
    if [ ! -s "$completed_tasks_file" ]; then
        echo "No completed tasks."
    else
        echo "Completed tasks:"
        cat "$completed_tasks_file"
    fi
}

delete_task() {
    echo -n "Enter task to delete: "
    read task

    if grep -Fxq "$task" "$undone_tasks_file"; then
        grep -vFx "$task" "$undone_tasks_file" > temp.txt && mv temp.txt "$undone_tasks_file"
        echo "$task" >> "$deleted_tasks_file"
        echo "Task deleted: $task"
    elif grep -Fxq "$task" "$completed_tasks_file"; then
        grep -vFx "$task" "$completed_tasks_file" > temp.txt && mv temp.txt "$completed_tasks_file"
        echo "$task" >> "$deleted_tasks_file"
        echo "Task deleted: $task"
    else
        echo "Task not found in undone or completed tasks."
    fi
}

show_deleted_tasks() {
    if [ ! -s "$deleted_tasks_file" ]; then
        echo "No deleted tasks."
    else
        echo "Deleted tasks:"
        cat "$deleted_tasks_file"
    fi
}

search_tasks() {
    echo -n "Enter search term: "
    read term

    echo "Search results for '$term':"
    echo "Undone tasks:"
    grep -i "$term" "$undone_tasks_file"

    echo "Completed tasks:"
    grep -i "$term" "$completed_tasks_file"

    echo "Deleted tasks:"
    grep -i "$term" "$deleted_tasks_file"
}

show_menu() {
    echo "Menu:"
    echo "1. Add new task"
    echo "2. Show undone tasks"
    echo "3. Mark task as done"
    echo "4. Show completed tasks"
    echo "5. Delete task"
    echo "6. Show deleted tasks"
    echo "7. Search tasks"
    echo "8. Exit"
}

initialize_files

while true; do
    show_menu

    echo -n "Enter your choice: "
    read choice

    case $choice in
        1) add_task ;;
        2) show_undone_tasks ;;
        3) mark_task_done ;;
        4) show_completed_tasks ;;
        5) delete_task ;;
        6) show_deleted_tasks ;;
        7) search_tasks ;;
        8) exit ;;
        *) echo "Invalid choice. Please try again." ;;
    esac

    echo
done