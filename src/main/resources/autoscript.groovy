def pollution_data = system 'curl http://api.waqi.info/feed/shanghai/?token=demo'
def status = jq pollution_data, '.status'

println status

if (!"ok" == status) {
    System.exit(1)
}

def aqi = jq pollution_data, '.data.aqi'
def idx = jq pollution_data, '.data.idx'

def record = jq "[${aqi}, ${idx}]", '{pollution:.[0],index:.[1]}'


def call_output = system record, "curl https://httpbin.org/post -d@-"



print call_output



