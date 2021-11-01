//
//  PeopleView.swift
//  iosApp
//
//  Created by Kevin on 01/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PeopleView: View {
    var character: People

    var body: some View {
        HStack() {
        VStack(alignment: .leading, spacing: 10.0) {
            Text(character.name)
            Text("Birth year: \(character.birthYear)").foregroundColor(.green)
            Text("Height: \(character.height) cm")
            Text("Mass: \(character.mass) kg")
            Text("Complexion: \(character.skinColor)")
            Text("Hair color: \(character.hairColor)")
            Text("Eye color: \(character.eyeColor)")
            Text("Gender: \(character.gender)")
            Text("# of films: \(String(character.films.count))").foregroundColor(.green)
            Text("# of vehicles: \(String(character.vehicles.count))").foregroundColor(.green)
            }
        }
    }
}

//struct PeopleView_Previews: PreviewProvider {
//    static var previews: some View {
//        PeopleView()
//    }
//}
