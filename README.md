# Entity
Task
一個用來記錄任務內容與狀態的物件


Project
由多個Task組成的List

# useCase
Tasks
用來儲存所有Task，產生、取得等等都在這裡實作

Projects
用來儲存所有Project，產生、取得等等都在這裡實作

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

# Adapter
1. Controller
*  CommandController
   要使用所有的Command需要使用各自的Controller來呼叫才能得到物件，所有的Controller有:
    * AddController
    * AddProjectController
    * AddTaskController
    * CheckController
    * UnCheckController
    * ErrorController
    * HelpController
    * ShowController
* CommandControllers
  一個用來取得CommandController的物件

2. Presenter
* CommandPresenter
  會接收一個Command物件以及一個IO物件，將Command的結果傳給IO

# IO
一個讓所有不同類型的IO繼承的抽象類別，有以下子類別:
* Shell