// CONTROLLERS
profileApp.controller('homeController', ['$scope', '$location', 'cityService', function($scope, $location, cityService) {
    

    
}]);

profileApp.controller('homeController', ['$scope', '$location', 'cityService', function($scope, $location, cityService) {
    

    
}]);

profileApp.controller('forecastController', ['$scope', '$routeParams', 'cityService', 'weatherService', function($scope, $routeParams, cityService, weatherService) {
    
    $scope.city = cityService.city;
    
    $scope.days = $routeParams.days || '2';
    
    $scope.weatherResult = weatherService.GetWeather($scope.city, $scope.days);
    
    $scope.convertToFahrenheit = function(degK) {
        
        return Math.round((1.8 * (degK - 273)) + 32);
        
    }
    
    $scope.convertToCelsius = function(degK) {
        
        return Math.round(degK - 273.15);
        
    }
    
    $scope.convertToDate = function(dt) { 
      
        return new Date(dt * 1000);
        
    };
    
}]);