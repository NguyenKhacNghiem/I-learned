import matplotlib.pyplot as plt
import collections

text = 'he really did look like a tourist with a camera around his neck and a bottle of sunscreen sticking out of his tote bag the portly man sat on the terrace sipping lemonade and pretending to look at a glossy cruise brochure his sunglasses masked his eyes but I knew he wasn\'t looking at the brochure he hadn\'t turned a page for the last ten minutes as I brought him his clam chowder he coughed up a thank you and looked at me briefly I tried not to stare at the tiny scar across his left eyebrow I walked back inside with my empty tray shaking my head he looked familiar but I couldn\'t quite place him then it hit me the car accident the mysterious stranger who helped me out of my smashed car just before it exploded I rushed back to his table he was gone I moved his saucer and found his tip along with a card I am deeply indebted to you the night of your car accident I was on my way to rob a jewelry store saving your life brought things back in perspective I now live an honest life thanks to you god bless you I shivered the night of my car accident I was heading for an interview in a shady dance club seeing human kindness through his heroic gesture turned my life around and brought faith back into my life I unfolded the tip he left among the singles was a grand with a pen mark underlining in god we trust I said a silent prayer for him and got back to work smiling'
words = text.split(' ')

frequency = collections.Counter(words)
print(frequency)

fig,ax = plt.subplots(1, 1)

ax.hist(frequency, bins = 30)
ax.set_title('Frequency of each word by histogram')
ax.set_xlabel('words')
ax.set_ylabel('frequencies (bin = 30)')

plt.show()