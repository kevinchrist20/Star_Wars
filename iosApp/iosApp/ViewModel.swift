//
//  ViewModel.swift
//  iosApp
//
//  Created by Kevin on 01/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class ViewModel: ObservableObject {
    let starWarsRepository = StarWarsRepo()

    @Published var results = State.loading

    init() {
        self.results = .loading
        starWarsRepository.getPeoples(completionHandler: { apiResults, error in
        if apiResults != nil {
            self.results = .success(apiResults!)
        } else {
            self.results = .error(error?.localizedDescription ?? "error")
        }
        })
    }
}

