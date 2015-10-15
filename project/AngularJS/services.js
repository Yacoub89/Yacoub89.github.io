// SERVICES
weatherApp.service('cityService', function() {
   
    this.city = "Ottawa, ON";
    
});


weatherApp.service('weatherService', ['$resource', function($resource) {
   
    this.GetWeather = function(city, days) {
        var weatherAPI = $resource("http://api.openweathermap.org/data/2.5/forecast/daily", { callback: "JSON_CALLBACK" }, { get: { method: "JSONP" }});
    
        return weatherResult = weatherAPI.get({ q: city, cnt: days, APPID:'6279bff69eb9d739f0b65fb97fa4caf8'  });
    };
    
}]);