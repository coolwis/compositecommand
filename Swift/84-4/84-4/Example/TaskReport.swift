//
//  TaskReport.swift
//  84-4
//
//  Created by tskim on 22/10/2019.
//  Copyright © 2019 assin. All rights reserved.
//

import Foundation

/*
 TaskReport 는 Composite pattern 이다.
 
 TaskReport 는 Leaf 이자 Tree 가 된다.
 */
class TaskReport {
    private let task: CompositeTask

    private(set) var _list = [TaskReport]()
    
    public init(task: CompositeTask) {
        self.task = task
    }
    
    func add(report: TaskReport) {
        _list.append(report)
    }
    
    func getReport(sortType: SortType) {
         let tasks_list.sorted(by: sortType.comparable)
        TaskReport(task: self)
        
        for t in _list {
            
        }
    }
}
