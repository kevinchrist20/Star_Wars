//
//  CharacterView.swift
//  iosApp
//
//  Created by Kevin on 01/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CharacterView: View {
    var character: People
    
    var body: some View {
        NavigationLink(destination: PeopleView(character: character), label: {
            HStack() {
                VStack(alignment: .leading, spacing: 10.0) {
                    Text(character.name)
                    Text("Birth year: \(character.birthYear)").foregroundColor(.green)
                    HStack() {
                        Text("Height: \(character.height) cm")
                        Spacer()
                        Text("Mass: \(character.mass) kg")
                    }
                    HStack() {
                        Text("Complexion: \(character.skinColor)")
                        Spacer()
                        Text("Hair color: \(character.hairColor)")
                    }
                    HStack() {
                        Text("Eye color: \(character.eyeColor)")
                        Spacer()
                        Text("Gender: \(character.gender)")
                    }
                    Text("# of films: \(String(character.films.count))").foregroundColor(.green)
                }
                Spacer()
            }
                
            })
    }
}

//struct CharacterView_Previews: PreviewProvider {
//    static var previews: some View {
//        CharacterView()
//    }
//}
