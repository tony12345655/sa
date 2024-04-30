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

# useCase

## port.input.command
### Command
一個Interface
### CommandUseCase
繼承Command Interface

## port.input.query
### Query
一個Interface
### HelpUseCase
繼承Query Interfact，也是個Interfact，讓HelpService繼承
### ShowUseCase
繼承Query Interfact，也是個Interfact，讓ShowService繼承

## port.output.command
### CommandOuput
command的輸出屬性，裡面有一個成員message型態為字串
### CommandPresenter
一個Interface，會讓Adapter層的實作presenter繼承

## port.output.query
裡面有兩種Query，每Query都有他自己的Output與DTO，也有presenter來讓Adapter曾繼承

## port.output.projects
裡面包含Task、Project、Projects三種Entity物件的DTO與PO，並且各自有Mapper來進行轉換，還有一個ProjectsRepository的Interface來讓Adapter層的實作繼承

## port.service
實作所有command與query，總共有以下service
* AddService
* AddProjectService
* AddTaskService
* CheckService
* UnCheckService
* ErrorService
* HelpService
* ShowService

# Adapter
## adpater.input.controller.console
裡面每一個controller會去對應相對的service，將傳進來的指令解析並取得service的回傳，再讓presenter表示出結果。有一個ControllerExcute來當作給client使用的入口。

## adpater.output.presenter.console
裡面有三種不同的presenter會對應到不同的usecase回傳結果去表示出結果

## adpater.output.repositroy
實作repository的地方，會繼承useCase層的Interface並將以PO的方式來儲存實體以避免跨層

# IO
1. TaskListAPP
   主程式所在的地方，判斷該呼叫哪些Controller與Presenter，負責做DI