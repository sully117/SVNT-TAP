# import sys
import json
import csv
import time

focusTopic = "animals"
focusTopicNumber = 15
####### not sure how to relate to json file data yet
# dataJSON = "US_category_id.json"
# with open(dataJSON, 'r') as myfile:
#     datastore = myfile.read()
#     pObj = json.loads(datastore)
#     for line in pObj['items']:
#         #find the topic we want

# current year
currentYear = time.localtime()[0]
# csv file, can be read from command line or input
fileCSVData = "USvideos.csv"
wantTopicCategory = []
columnTime = 5
fourDigitYear = 4

# opening csv
with open(fileCSVData) as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    firstRow = True
    titles = None
    print("Reading data, please wait...")
    for row in readCSV:
        if firstRow:
            firstRow = False
            titles = row
            continue

        # find interest
        if int(row[4]) == focusTopicNumber and currentYear - int(row[columnTime][:fourDigitYear]) == 1:
            wantTopicCategory.append(row)
    print('Finish reading data.')
print()
# we have the data related to "animal" within 1 year
## we can show the client the data we have
lookup = True
# there is a bug, need to fix
while lookup:
    print('Please choose between 1 and ' + str(len(titles)) + ' or quit/exit to quit')
    print(titles)
    option = input("Data interested in : ")
    if option.isalpha():
        option = option.lower()
        if option == "e" or option == "exit" or option == "quit" or option == "q":
            break
        else:
            print("Please choose a valid choice")
    elif option.isdigit():
        option = int(option)
        if option < 1 or option > len(titles):
            print("Please choose a valid choice")
        else:
            for content in wantTopicCategory:
                print(content[option])
    else:
        print("Please choose a valid choice")
