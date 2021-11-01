//
//  State.swift
//  iosApp
//
//  Created by Kevin on 01/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

enum State {
    case loading
    case success(PeopleResponse)
    case error(String)
}
