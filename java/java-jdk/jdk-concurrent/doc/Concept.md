# 进程

# 线程

# 协程

## 简介

用户级线程。一个线程可以对应多个协程，调度协程的系统在语言层面实现

## 协程出现的原因

协程主要是为了提高并发，而且主要是IO并发。协程并不适合并行计算或者并行处理任务，因为同一时刻运行的协程数不可能大于操作系统线程，而且需要协程切换，不如线程池。对于IO密集任务，利用回调函数，配合协程，可以使逻辑更加简单清晰，不过协程可以做的，线程一样可以做，比如Reactor模型。

## 原理

- 线程是进程的执行体,拥有一个执行入口,以及从进程虚拟地址空间分配的栈信息,包括用户栈和内核栈
- 操作系统会记录线程控制信息
- 线程获得CPU时间片以后才可以执行
- CPU切换对应线程的栈基、栈指针、指令指针等寄存器
- 如果线程各自创建几个执行体,给他们各自指定执行入口,申请一些内存分配给他们做执行栈,那么线程就可以按需调度这几个执行体了
- 为了实现这几个执行体的切换,线程也需要记录执行体的信息,包括ID、栈的位置、执行入口地址、执行现场等等
- 线程可以选择一个执行体来执行,此时CPU中指令指针就会指向这个执行体的执行入口,栈基和栈指针寄存器也会指向线程给他分配的执行栈
- 要切换执行体时,需要先保存当前执行体的执行现场,然后切换到另一个执行体,通过同样的方式可以恢复到之前的执行体,这样就可以从上次执行中断的地方继续执行
- 这些由线程创建的执行体就叫做“协程,因为用户程序不能操作内核空间,所以只能给协程分配用户栈,二操作系统对协程一无所知,所以协程又被称为“用户态线程”



- 无论协程怎么被创建,底层都要分配执行栈和控制信息
- 让出执行权时候,都要保存执行现场,以便后续回复

## 协程关键`控制 流的让出和恢复`

- 每个协程又自己的执行栈,可以保存自己的执行现场
- 可以由用户程序按需创建协程
- 协程“主动让出”执行权时候,会保存执行现场,然后切换到其他协程
- 协程恢复执行时候会根据之前保存的执行现场恢复到中断前的状态,继续执行,这样就通过协程实现了既轻量又灵活的由用户态调度的多任务模型

