import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { CityService } from '../service/city.service';
import { City } from '../model/city';

@Component({
  selector: 'app-city-form',
  templateUrl: './city-form.component.html',
  styleUrls: ['./city-form.component.css']
})
export class CityFormComponent implements OnInit {

  city: City;
  cityId: number;

  constructor(private cityService: CityService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.cityId = this.route.snapshot.params['id'];
    this.cityService.findById(this.cityId).subscribe(data => {
      this.city = data;
    });
  }

  save() {
    this.cityService.update(this.cityId, this.city).subscribe(() => {
      this.gotoCityList();
    });
  }

  gotoCityList() {
    this.router.navigate(['/']);
  }
}
