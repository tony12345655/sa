## 將所有的指令都寫成物件並讓他們繼承一個Command的Interface
* AddCommand
* AddProjectCommand
* AddTaskCommand
* CheckCommand
* UnCheckCommand
* ErrorCommand
* HelpCommand
* ShowCommand

## 如果要用到核心物件像是Task、Project、Command必須透過他們各自的Application來使用
* TaskApplication
* ProjectApplication
* CommandApplication

## IO的部分會有一個IO的Interface來讓不同類型的IO繼承
* Shell

## 會有一個Adapter物件來接收IO去使用功能
* CommandAdapter