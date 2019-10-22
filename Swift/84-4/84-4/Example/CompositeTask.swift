//
//  CompositeTask.swift
//  84-4
//
//  Created by tskim on 22/10/2019.
//  Copyright © 2019 assin. All rights reserved.
//

import Foundation

/*
 Composite pattern 의 그룹 객체를 가진다.
 */
class CompositeTask {
    var title: String
    var date: Date
    var isComplete: Bool
    private let list = [Task]()

    public init(title: String, date: Date, isComplete: Bool = false) {
        self.title = title
        self.date = date
        self.isComplete = isComplete
    }
    
    public func toggle() {
        isComplete = !isComplete
    }
    
    func getList(sortType: SortType) -> [Task] {
        let tasks = Array(list)
        /*
         Task, [Task] 형태를 가진다.
         */
        
        return tasks.sorted(by: sortType.comparable)
    }
}
