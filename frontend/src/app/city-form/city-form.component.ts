import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CityService } from '../service/city.service';
import { City } from '../model/city';

@Component({
  selector: 'app-city-form',
  templateUrl: './city-form.component.html',
  styleUrls: ['./city-form.component.css']
})
export class CityFormComponent {

  city: City;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private cityService: CityService) {
    this.city = new City();
  }

  onSubmit() {
    this.cityService.save(this.city).subscribe(result => this.gotoCityList());
  }

  gotoCityList() {
    this.router.navigate(['/cities']);
  }
}
