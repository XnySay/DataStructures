cmake_minimum_required(VERSION 3.29)
project(Stack C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(Stack
        SeqStack.c)
