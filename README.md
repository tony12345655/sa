# Entity
Task
一個用來記錄任務內容與狀態的物件


Project
由多個Task組成的List

ProjectDescription
用來儲存project物件所需的靜態參數，如name等等

Projects
用來儲存多個Project

# useCase
Command
所以所需的指令都需要繼承這個抽象類別，其子類別有:
* AddCommand
* AddProjectCommand
* AddTaskCommand
* CheckCommand
* UnCheckCommand
* ErrorCommand
* HelpCommand
* ShowCommand

CommandDescription
用來儲存command物件所需的靜態參數，如name等等

ProjectsModel
一個能對projects進行新增、取得等方法的物件

# Adapter
1. Controller
*  CommandController
   取的要使用的Command並在裡面執行Command再回傳結果

2. Presenter
* TaskListPresenter
  接收Controller回傳的結果與IO，並將它表示出來

# IO
1. TaskListRunner
   主程式所在的地方，負責做DI