import csv

def sredi_datum(line):
    if "AM" in line:
        return line.replace(line, "night")
    return line.replace(line, "day") #u slučaju da je dan, ali i ako se pošalje prazan string postaje dan bmk

def sredi_district(distric_id):
    if(distric_id == "1"):
        return "A"
    elif(distric_id == "2"):
        return "B"
    elif (distric_id == "3"):
        return "C"
    elif (distric_id == "4"):
        return "D"
    elif (distric_id == "5"):
        return "E"
    elif (distric_id == "6"):
        return "F"
    return "G"

def sredi_flag(flag):
    if(flag=="1"):
        return "true"
    return "false"

def sredi_crime(line):
    if ("theft" or "larceny") in line:
        return line.replace(line, "theft")
    elif "traffic" in line:
        return line.replace(line, "traffic")
    elif ("burglary" or "robbery") in line:
        return line.replace(line, "burglary")
    elif ("kidnap" or "other-crime-against-persons" or "arson" or "assault" or "weapon") in line:
        return line.replace(line, "violent-assault")
    elif ("drug" or "alcohol") in line:
       return line.replace(line, "opiates")
    elif "all-other-crimes" in line:
        return line.replace(line, "small-crime")
    return line

def testna_string(line):
    if any(line.findall("niko")):
        return "ana"



with open("C:\\Users\\Korisnik\\Desktop\\crime.csv", newline='') as file:
    csv_f = list(csv.reader(file, delimiter=","))

title = (csv_f[0][5],csv_f[0][8],csv_f[0][14], csv_f[0][16], csv_f[0][17], csv_f[0][18])
with open('C:\\Users\\Korisnik\\Desktop\\crime_format.csv', 'w') as writeFile:
    writer = csv.writer(writeFile, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
    writer.writerows(['Maja', 'AXra'])
""""
with open('C:\\Users\\Korisnik\\Desktop\\crime_sreden.csv', mode='w', newline='') as writeMe:
    writer = csv.writer(writeMe, delimiter=',', quotechar='"', quoting=csv.QUOTE_ALL)
    writer.writerow(title)
    for x in range(len(csv_f)):
        offense = sredi_crime(csv_f[x][5])
        datum = sredi_datum(csv_f[x][8])
        district = sredi_district(csv_f[x][14])
        crime = sredi_flag(csv_f[x][17])
        traffic = sredi_flag(csv_f[x][18])
        line = (offense,datum,district, csv_f[x][16],crime,traffic)
        writer.writerow(line)
"""


stringic ="danas je suncan dan"
print(testna_string(stringic))


