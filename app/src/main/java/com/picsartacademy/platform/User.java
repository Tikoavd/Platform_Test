package com.picsartacademy.platform;

public class User {
    private String  id, name, username, email, phone, website;
    private Address address;
    private Company company;

    public class Address {
        String street, suite, city, zipcode;
        Geo geo;

        public class Geo {
            String lat, lng;

            public String getLat() {
                return lat;
            }

            public String getLng() {
                return lng;
            }
        }

        public String getStreet() {
            return street;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public Geo getGeo() {
            return geo;
        }
    }

    public class Company {
        String name, catchPhrase, bs;

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }
}
