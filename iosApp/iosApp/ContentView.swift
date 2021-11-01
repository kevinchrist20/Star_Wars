import SwiftUI
import shared

struct ContentView: View {
	  @ObservedObject private(set) var viewModel: ViewModel


	var body: some View {
        NavigationView {
            listView()
            .navigationBarTitle("Star Wars Characters")
        }
	}
    
    private func listView() -> AnyView {
        switch viewModel.results {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .success(let peopleResponse):
            return AnyView(List(peopleResponse.peoples, id: \.self) { people in
                CharacterView(character: people)
            })
        case .error(let errorMsg):
            return AnyView(Text(errorMsg).multilineTextAlignment(.center))
        }
    }
}

//struct ContentView_Previews: PreviewProvider {
//	static var previews: some View {
//		ContentView()
//	}
//}
