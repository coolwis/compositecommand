//
//  Visitor.swift
//  84-4
//
//  Created by tskim on 22/10/2019.
//  Copyright © 2019 assin. All rights reserved.
//

import Foundation


protocol Visitor {
    /*
     Visitor 에 2가지 Lifecycle 을 얻을 수 있다.
     [drawTask, end]
     
     */
    func drawTask(task: CompositeTask, depth: Int)
    func end(depth: Int)
}

class ConsoleVisitor: Visitor {
    func drawTask(task: CompositeTask, depth: Int) {
        var padding = ""
        (0..<depth).forEach { _ in
            padding += "-"
        }
        let isCompletedOut = task.isCompleted ? "[v]" : "[ ]"
        print("\(padding) \(isCompletedOut) \(task.title) (\(task.date))")
    }
    
    func end(depth: Int) {
        
    }
}
