import matplotlib as plt
import networkx as nx

# Example
# g = nx.Graph()   # do thi vo huong
g = nx.DiGraph()   # do thi co huong
g.add_edges_from([('A', 'B'), ('A', 'C') , ('E', 'F'), ('A', 'G'), ('B', 'E')])
nx.draw(g, with_labels = True) # with_labels = False -> an ten may cai dinh cua do thi
plt.pyplot.show()
# tim duong di ngan nhat
print(nx.shortest_path(g, 'A', 'C', weight = 'weight'))

g1 = nx.Graph()
g1.add_edges_from([('1', '4'), ('4', '3') , ('4', '2')])
nx.draw(g1, with_labels = True)
plt.pyplot.show()

g2 = nx.Graph()
g2.add_edges_from([('1', '2'), ('2', '3') , ('3', '4'), ('4', '1')])
nx.draw(g2, with_labels = True)
plt.pyplot.show()

g3 = nx.Graph()
g3.add_edges_from([('1', '2'), ('2', '4') , ('4', '3'), ('3', '1'), ('1', '4'), ('2', '3')])
nx.draw(g3, with_labels = True)
plt.pyplot.show()

g4 = nx.Graph()
g4.add_edges_from([('1', '4'), ('2', '3') , ('1', '3'), ('2', '4')])
nx.draw(g4, with_labels = True)
plt.pyplot.show()

g5 = nx.Graph()
g5.add_edges_from([('1', '2'), ('3', '4') , ('1', '3'), ('2', '4')])
nx.draw(g5, with_labels = True)
plt.pyplot.show()