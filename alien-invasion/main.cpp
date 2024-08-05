#ifndef _CRT_SECURE_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <stdio.h>
#include <time.h>

static unsigned int pseudo_rand(void) {
	static unsigned long long seed = 5;
	seed = seed * 25214903917ULL + 11ULL;
	return (unsigned int) (seed >> 16);
}

static const int TC = 100;

static const int WEAPON_COUNT = 8;
static const int TARGET_COUNT = 1000;

extern void destroy(int, int, int[], int[]);

static int ammo[WEAPON_COUNT];
static int ammo_bak[WEAPON_COUNT];

static int hitpoint[TARGET_COUNT];
static int hitpoint_bak[TARGET_COUNT];

static const int WEAPON_DAMAGE[WEAPON_COUNT] = {
	5000,
	1000,
	500,
	100,
	50,
	10,
	5,
	1
};

bool attack(int target, int weapon, int attack_count) {
	if (target < 0 || target >= TARGET_COUNT) {
		return false;
	}

	if (weapon < 0 || weapon >= WEAPON_COUNT) {
		return false;
	}

	if (attack_count < 0 || attack_count > ammo[weapon]) {
		return false;
	}

	if (WEAPON_DAMAGE[weapon] * attack_count > hitpoint[target]) {
		return false;
	}

	ammo[weapon] -= attack_count;
	hitpoint[target] -= WEAPON_DAMAGE[weapon] * attack_count;

	return true;
}

static void generate_tc(void) {
	for (int i = 0; i < 8; i++) {
		ammo[i] = ammo_bak[i] = pseudo_rand() % 1500 + 500;
	}
	for (int i = 0; i < TARGET_COUNT; i++) {
		hitpoint[i] = hitpoint_bak[i] = pseudo_rand() % 10000 + 1;
	}
}

static int calculate_score() {
	int score = 0;

	for (int i = 0; i < TARGET_COUNT; i++) {
		if (hitpoint[i] == 0) {
			score += 1;
		}
	}
	return score;
}

int main() {
	time_t time_begin = clock();
	int total_score = 0;

	for (int tc = 0; tc < TC; tc++) {
		generate_tc();
		destroy(WEAPON_COUNT, TARGET_COUNT, ammo_bak, hitpoint_bak);

		total_score += calculate_score();
	}

	time_t time_end = clock();

	printf("SCORE: %d\n", total_score);
	printf("TIME : %ld ms\n", (time_end - time_begin) * 1000 / CLOCKS_PER_SEC);

	return 0;
}
