#!/bin/bash

create_files() {
    for ((i=1; i<=5; i++)); do
        touch "file$i.txt"
    done
    echo "Five text files created."
}

add_hello_world() {
    for ((i=1; i<=5; i++)); do
        echo "Hello world" >> "file$i.txt"
    done
    echo "Added 'Hello world' to all files."
}

replace_world_with_bash() {
    for ((i=1; i<=5; i++)); do
        sed -i 's/world/bash/g' "file$i.txt"
    done
    echo "Replaced 'world' with 'bash' in all files."
}

print_files() {
    for ((i=1; i<=5; i++)); do
        echo "Contents of file$i.txt:"
        cat "file$i.txt"
        echo
    done
}


while true; do

    PS3="Enter your choice: "
    select choice in "Create Files" "Add Hello world" "Replace World with Bash" "Print File Contents" "Exit"; do
        case $choice in
            "Create Files")
                create_files
                break
                ;;
            "Add Hello world")
                add_hello_world
                break
                ;;
            "Replace World with Bash")
                replace_world_with_bash
                break
                ;;
            "Print File Contents")
                print_files
                break
                ;;
            "Exit")
                exit
                ;;
            *)
                echo "Invalid choice. Please try again."
                ;;
        esac
    done

    echo
done