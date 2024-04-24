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
## Command
沒有對資料查詢的指令需繼承這個抽象類別，其子類別有:
* AddCommand
* AddProjectCommand
* AddTaskCommand
* CheckCommand
* UnCheckCommand
* ErrorCommand

## Query
有需要將資料回傳的指令需繼承這個抽象類別，其子類別有:
* HelpQuery
* ShowQuery

## ProjectsRepository
一個能對projects進行新增、取得等方法的物件

## InputData
將command與query所需的input分別寫成兩種物件，其中query為了考慮到沒有請求而需要回傳的情況所以有個nullQueryInput

## OutputData
所有的command因為output資料型態都一樣所以共用一個CommandOutput，而query由於所需回傳的資料型態不同因此每種query都有它自己的output，像是HelpOutput

## Dto
總共有四個Dto物件，分別為:
* ProjectsDto
* ProjectDto
* TaskDto
* HelpDto

## Mapper
負責將物件轉成Dto，分別有:
* ProjectsMapper
* ProjectMapper
* TaskMapper

# Adapter
## Controller
*  CommandController
   會接收一個字串並轉為InputData傳入Command中得到一個OutputData，並將資訊回傳
*  HelpController
   會回傳取得資料的Dto物件
*  ShowController
   會回傳取得資料的Dto物件


## Presenter
總共有三個Presenter，分別是ConsoleCommandPresenter、ConsoleHelpPresenter、ConsoleShowPresenter，都會接收一個PrintWriter物件與分別對應的Controller回傳的結果，再將結果顯示出來

# IO
1. TaskListRunner
   主程式所在的地方，判斷該呼叫哪些Controller與Presenter，負責做DI