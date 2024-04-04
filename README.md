# Entity
Task
一個用來記錄任務內容與狀態的物件

ReadOnlyTask
繼承Task，不能修改Task內容的物件

Project
由多個Task組成的List

ProjectName
用來儲存project名子的物件

ReadOnlyProject
繼承Project，不能修改Project內容的物件

Projects
用來儲存多個Project

ReadOnlyProjects
繼承Projects，不能修改Projects內容的物件

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

CommandName
用來儲存Command名稱的物件

ProjectsRepository
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